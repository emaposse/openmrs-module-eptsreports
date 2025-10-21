	select finalTable.patient_id from
	(
	select final.patient_id, 1 fonte
	from
	(
	select final.patient_id from
	(
	select final.patient_id from
	(
	select p.patient_id, max( e.encounter_datetime) from patient p  
	inner join encounter  e on e.patient_id=p.patient_id  
	inner join obs o on o.encounter_id=e.encounter_id  
	where p.voided=0  
	and e.voided=0 and 
	o.voided=0  
	and e.encounter_type=97  
	and o.concept_id=165535  
	and o.value_coded=165536  
	and e.encounter_datetime<=:endDate  
	and e.location_id=:location 
	group by p.patient_id
	)final
	
	union
	
	select f.patient_id
	from
	(
	select final.patient_id,
	    	  MAX(CASE WHEN final.valor = 'T1' then final.encounter_datetime END) as data_primeira_consulta,
	    	  MAX(CASE WHEN final.valor = 'T2' then final.encounter_datetime END) as data_segunda_consulta,
	    	  MAX(CASE WHEN final.valor = 'T3' then final.encounter_datetime END) as data_segunda_consulta_periodoa
	   
	
	from
	(
	select p.patient_id, min(e.encounter_datetime)  encounter_datetime, "T1" valor 
	from patient p 
	inner join encounter  e on e.patient_id=p.patient_id 
	where p.voided=0 
	and e.voided=0 
	and e.encounter_type=6  
	and e.encounter_datetime<=:endDate
	and e.location_id=:location 
	group by p.patient_id 
	
	union
	
	select segunda.patient_id,min(e.encounter_datetime) encounter_datetime, "T2" valor   from
	(
	select p.patient_id, min(e.encounter_datetime) data_primeira_consulta
	from patient p 
	inner join encounter  e on e.patient_id=p.patient_id 
	where p.voided=0 
	and e.voided=0 
	and e.encounter_type=6  
	and e.encounter_datetime<=:endDate 
	and e.location_id=:location 
	group by p.patient_id 
	)segunda
	left join encounter e on e.patient_id=segunda.patient_id  and e.encounter_type=6 and e.encounter_datetime>segunda.data_primeira_consulta
	group by segunda.patient_id
	
	union
	
	select p.patient_id, min(e.encounter_datetime) encounter_datetime, "T3" valor 
	from patient p 
	inner join encounter  e on e.patient_id=p.patient_id 
	where p.voided=0 
	and e.voided=0 
	and e.encounter_type=6  
	and e.encounter_datetime>=:startDate 
	and e.encounter_datetime<=:endDate 
	and e.location_id=:location 
	group by p.patient_id 
	
	)final
	group by final.patient_id
	)f
	where (f.data_segunda_consulta > :startDate) 
	)final
	)final
	
	union
	
	
	select final.patient_id, 2 fonte
	from
	(
	select final.patient_id from
	(
	select p.patient_id, max(e.encounter_datetime) from patient p 
	inner join encounter  e on e.patient_id=p.patient_id 
	inner join obs o on o.encounter_id=e.encounter_id 
	where p.voided=0  
	and e.voided=0 and o.voided=0  
	and e.encounter_type=97  
	and o.concept_id=165535  
	and o.value_coded=23912 
	and e.encounter_datetime<=:endDate
	and e.location_id=:location 
	group  by p.patient_id
	)final
	
	union
	
	select cvAlta.patient_id  
	from   
	(  
	select p.patient_id, max(o.obs_datetime) data_cv_alta  
	from patient p  
	inner join encounter  e on e.patient_id=p.patient_id  
	inner join obs o on o.encounter_id=e.encounter_id  
	where p.voided=0   
	and e.voided=0   
	and o.voided=0   
	and e.encounter_type in(6,13,51,53) 
	and o.obs_datetime>=:startDate   
	and o.obs_datetime<=:endDate  
	and e.location_id=:location  
	and o.concept_id=856  
	group by p.patient_id  
	)cvAlta  
	left join obs o on o.person_id=cvAlta.patient_id   
	where o.obs_datetime=cvAlta.data_cv_alta and o.concept_id=856 and o.value_numeric>1000 
	
	)final
	group  by final.patient_id
	
	union
	
	
	select final.patient_id, 3 fonte
	from
	(
	select final.patient_id from
	(
	select p.patient_id,max(e.encounter_datetime) from patient p 
	inner join encounter  e on e.patient_id=p.patient_id 
	inner join obs o on o.encounter_id=e.encounter_id 
	where p.voided=0  
	and e.voided=0 and o.voided=0  
	and e.encounter_type=97  
	and o.concept_id=165535  
	and o.value_coded in(6311,23993) 
	and e.encounter_datetime<=:endDate
	and e.location_id=:location
	group  by p.patient_id 
	)final
	
	union
	
	select maAdesaoOtrasFontes.patient_id
	from 
	( 
	select p.patient_id, max(e.encounter_datetime) data_estado from patient p 
	inner join encounter  e on e.patient_id=p.patient_id 
	inner join obs o on o.encounter_id=e.encounter_id 
	where p.voided=0  
	and e.voided=0 and o.voided=0  
	and e.encounter_type=6  
	and o.concept_id=6273	  
	and o.value_coded=1705 
	and e.encounter_datetime>=:startDate  
	and e.encounter_datetime<=:endDate
	and e.location_id=:location 
	group by p.patient_id 
	union 
	select p.patient_id, o.obs_datetime data_estado from patient p 
	inner join encounter  e on e.patient_id=p.patient_id 
	inner join obs o on o.encounter_id=e.encounter_id 
	where p.voided=0  
	and e.voided=0 and o.voided=0  
	and e.encounter_type=53  
	and o.concept_id=6272	  
	and o.value_coded=1705 
	and e.encounter_datetime>=:startDate  
	and e.encounter_datetime<=:endDate
	and e.location_id=:location  
	union 
	select p.patient_id, max(e.encounter_datetime) data_estado from patient p 
	inner join encounter  e on e.patient_id=p.patient_id 
	inner join obs o on o.encounter_id=e.encounter_id 
	where p.voided=0  
	and e.voided=0 and o.voided=0  
	and e.encounter_type in(6,35) 
	and o.concept_id=6223	  
	and o.value_coded=1385 
	and e.encounter_datetime>=:startDate  
	and e.encounter_datetime<=:endDate
	and e.location_id=:location   
	group by p.patient_id 
	)maAdesaoOtrasFontes 
	)final
	
	union
	
	
	select final.patient_id, 4 fonte
	from
	(
	select final.patient_id from
	(
	select p.patient_id from patient p 
	inner join encounter  e on e.patient_id=p.patient_id 
	inner join obs o on o.encounter_id=e.encounter_id 
	where p.voided=0  
	and e.voided=0 
	and o.voided=0  
	and e.encounter_type=35 
	and o.concept_id=6193 
	and o.value_coded in(1956,6303,207,1603)	  
	and e.encounter_datetime>=:startDate  
	and e.encounter_datetime<=:endDate 
	and e.location_id=:location 
	)final
	)final
	
	union 
	
	
	select p.patient_id, 5 fonte from patient p
	left join
	(
	select * from
	(
	select final.patient_id, 1 fonte
	from
	(
	select final.patient_id from
	(
	select final.patient_id from
	(
	select p.patient_id, max( e.encounter_datetime) from patient p  
	inner join encounter  e on e.patient_id=p.patient_id  
	inner join obs o on o.encounter_id=e.encounter_id  
	where p.voided=0  
	and e.voided=0 and 
	o.voided=0  
	and e.encounter_type=97  
	and o.concept_id=165535  
	and o.value_coded=165536  
	and e.encounter_datetime<=:endDate  
	and e.location_id=:location 
	group by p.patient_id
	)final
	
	union
	
	select f.patient_id
	from
	(
	select final.patient_id,
	    	  MAX(CASE WHEN final.valor = 'T1' then final.encounter_datetime END) as data_primeira_consulta,
	    	  MAX(CASE WHEN final.valor = 'T2' then final.encounter_datetime END) as data_segunda_consulta,
	    	  MAX(CASE WHEN final.valor = 'T3' then final.encounter_datetime END) as data_segunda_consulta_periodoa
	   
	
	from
	(
	select p.patient_id, min(e.encounter_datetime)  encounter_datetime, "T1" valor 
	from patient p 
	inner join encounter  e on e.patient_id=p.patient_id 
	where p.voided=0 
	and e.voided=0 
	and e.encounter_type=6  
	and e.encounter_datetime<=:endDate 
	and e.location_id=:location 
	group by p.patient_id 
	
	union
	
	select segunda.patient_id,min(e.encounter_datetime) encounter_datetime, "T2" valor   from
	(
	select p.patient_id, min(e.encounter_datetime) data_primeira_consulta
	from patient p 
	inner join encounter  e on e.patient_id=p.patient_id 
	where p.voided=0 
	and e.voided=0 
	and e.encounter_type=6  
	and e.encounter_datetime<=:endDate 
	and e.location_id=:location 
	group by p.patient_id 
	)segunda
	left join encounter e on e.patient_id=segunda.patient_id  and e.encounter_type=6 and e.encounter_datetime>segunda.data_primeira_consulta
	group by segunda.patient_id
	
	union
	
	select p.patient_id, min(e.encounter_datetime) encounter_datetime, "T3" valor 
	from patient p 
	inner join encounter  e on e.patient_id=p.patient_id 
	where p.voided=0 
	and e.voided=0 
	and e.encounter_type=6  
	and e.encounter_datetime>=:startDate 
	and e.encounter_datetime<=:endDate 
	and e.location_id=:location 
	group by p.patient_id 
	
	)final
	group by final.patient_id
	)f
	where (f.data_segunda_consulta > :startDate) 
	)final
	)final
	
	union
		
	select final.patient_id, 2 fonte
	from
	(
	select final.patient_id from
	(
	select p.patient_id, max(e.encounter_datetime) from patient p 
	inner join encounter  e on e.patient_id=p.patient_id 
	inner join obs o on o.encounter_id=e.encounter_id 
	where p.voided=0  
	and e.voided=0 and o.voided=0  
	and e.encounter_type=97  
	and o.concept_id=165535  
	and o.value_coded=23912 
	and e.encounter_datetime<=:endDate
	and e.location_id=:location 
	group  by p.patient_id
	)final
	
	union
	
	select cvAlta.patient_id  
	from   
	(  
	select p.patient_id, max(o.obs_datetime) data_cv_alta  
	from patient p  
	inner join encounter  e on e.patient_id=p.patient_id  
	inner join obs o on o.encounter_id=e.encounter_id  
	where p.voided=0   
	and e.voided=0   
	and o.voided=0   
	and e.encounter_type in(6,13,51,53) 
	and o.obs_datetime>=:startDate   
	and o.obs_datetime<=:endDate  
	and e.location_id=:location  
	and o.concept_id=856  
	group by p.patient_id  
	)cvAlta  
	left join obs o on o.person_id=cvAlta.patient_id   
	where o.obs_datetime=cvAlta.data_cv_alta and o.concept_id=856 and o.value_numeric>1000 
	
	)final
	group  by final.patient_id
	
	union
		
	select final.patient_id, 3 fonte
	from
	(
	select final.patient_id from
	(
	select p.patient_id,max(e.encounter_datetime) from patient p 
	inner join encounter  e on e.patient_id=p.patient_id 
	inner join obs o on o.encounter_id=e.encounter_id 
	where p.voided=0  
	and e.voided=0 and o.voided=0  
	and e.encounter_type=97  
	and o.concept_id=165535  
	and o.value_coded in(6311,23993) 
	and e.encounter_datetime<=:endDate
	and e.location_id=:location
	group  by p.patient_id 
	)final
	
	union
	
	select maAdesaoOtrasFontes.patient_id
	from 
	( 
	select p.patient_id, max(e.encounter_datetime) data_estado from patient p 
	inner join encounter  e on e.patient_id=p.patient_id 
	inner join obs o on o.encounter_id=e.encounter_id 
	where p.voided=0  
	and e.voided=0 and o.voided=0  
	and e.encounter_type=6  
	and o.concept_id=6273	  
	and o.value_coded=1705 
	and e.encounter_datetime>=:startDate  
	and e.encounter_datetime<=:endDate
	and e.location_id=:location 
	group by p.patient_id 
	union 
	select p.patient_id, o.obs_datetime data_estado from patient p 
	inner join encounter  e on e.patient_id=p.patient_id 
	inner join obs o on o.encounter_id=e.encounter_id 
	where p.voided=0  
	and e.voided=0 and o.voided=0  
	and e.encounter_type=53  
	and o.concept_id=6272	  
	and o.value_coded=1705 
	and e.encounter_datetime>=:startDate  
	and e.encounter_datetime<=:endDate
	and e.location_id=:location  
	union 
	select p.patient_id, max(e.encounter_datetime) data_estado from patient p 
	inner join encounter  e on e.patient_id=p.patient_id 
	inner join obs o on o.encounter_id=e.encounter_id 
	where p.voided=0  
	and e.voided=0 and o.voided=0  
	and e.encounter_type in(6,35) 
	and o.concept_id=6223	  
	and o.value_coded=1385 
	and e.encounter_datetime>=:startDate  
	and e.encounter_datetime<=:endDate
	and e.location_id=:location   
	group by p.patient_id 
	)maAdesaoOtrasFontes 
	)final
	
	union
		
	select final.patient_id, 4 fonte
	from
	(
	select final.patient_id from
	(
	select p.patient_id,max(e.encounter_datetime) from patient p 
	inner join encounter  e on e.patient_id=p.patient_id 
	inner join obs o on o.encounter_id=e.encounter_id 
	where p.voided=0  
	and e.voided=0 and o.voided=0  
	and e.encounter_type=97 
	and o.concept_id=6193	  
	and e.encounter_datetime<=:endDate
	and e.location_id=:location 
	group by p.patient_id 
	)final
	
	union
	select final.patient_id from
	(
	select p.patient_id from patient p 
	inner join encounter  e on e.patient_id=p.patient_id 
	inner join obs o on o.encounter_id=e.encounter_id 
	where p.voided=0  
	and e.voided=0 
	and o.voided=0  
	and e.encounter_type=35 
	and o.concept_id=6193 
	and o.value_coded in(1956,6303,207,1603)	  
	and e.encounter_datetime>=:startDate  
	and e.encounter_datetime<=:endDate 
	and e.location_id=:location 
	union 
	select  pg.patient_id from  patient p   
	inner join patient_program pg on p.patient_id=pg.patient_id 
	inner join patient_state ps on   ps.patient_program_id=pg.patient_program_id                        
	where pg.voided=0  
	and p.voided=0  
	and program_id=1  
	and date_enrolled<=:endDate 
	and location_id=:location 
	and ps.state in(1,28)  
	and pg.patient_id not in 
	( 
	select  pg.patient_id from  patient p   
	inner join patient_program pg on p.patient_id=pg.patient_id                          
	where pg.voided=0  
	and p.voided=0  
	and program_id=2  
	and date_enrolled<=:endDate 
	and location_id=:location  
	) 
	union 
	select fichaResumo.patient_id 
	from 
	( 
	select p.patient_id, o.value_datetime data from patient p 
	inner join encounter  e on e.patient_id=p.patient_id 
	inner  join obs o on o.encounter_id=e.encounter_id 
	where p.voided=0  
	and e.voided=0 
	and o.voided=0 
	and e.encounter_type=53 
	and o.concept_id=23891 
	and o.value_datetime<=:endDate 
	and e.location_id=:location 
	)fichaResumo 
	left join 
	( 
	select e.patient_id, min(e.encounter_datetime) as art_start_date from patient p  
	inner join encounter e on p.patient_id=e.patient_id  
	where p.voided=0  
	and e.encounter_type in(18,52)  
	and e.voided=0  
	and e.encounter_datetime<=:endDate  
	and e.location_id=:location  
	group by p.patient_id  
	)lev on fichaResumo.patient_id=lev.patient_id 
	where lev.patient_id is null 
	)final
	)final
	)finalTable
	group by finalTable.patient_id
	order by finalTable.patient_id,finalTable.fonte
	)tobeExclude on tobeExclude.patient_id=p.patient_id
	where tobeExclude.patient_id is null
	
	)finalTable
	where finalTable.fonte in(%s)
	group by finalTable.patient_id
	order by finalTable.patient_id,finalTable.fonte
