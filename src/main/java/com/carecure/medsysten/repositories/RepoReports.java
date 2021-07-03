package com.carecure.medsysten.repositories;

import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.transform.AliasToEntityMapResultTransformer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;

@Repository
public class RepoReports
{
	@PersistenceContext
	public EntityManager entityManager;

	public List<?> getMonthSpecialitiesIncome() {

		String queryString = "select speciality,DATE_FORMAT(resinvoice.dateFinalized, '%m-01-%Y') as date ,sum(totalAfterDiscount) as total\n"
				+ "from resinvoice\n" + "inner join resappointment r on resinvoice.appointmentCode = r.code\n"
				+ "group by speciality,DATE_FORMAT(resinvoice.dateFinalized, '%m-%Y')\n"
				+ "order by speciality,YEAR(resinvoice.dateFinalized),MONTH(resinvoice.dateFinalized);";

		Query query = entityManager.createNativeQuery(queryString);
		NativeQueryImpl nativeQuery = (NativeQueryImpl) query;
		nativeQuery.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
		List<Map<String,Object>> result = nativeQuery.getResultList();
		return result;

	}
}

