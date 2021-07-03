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

	public List<?> getMonthSpecialitiesIncomeReport() {

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

	public List<?> getMonthSpecialitiesCountReport(){

		String queryString = "\tselect\n" + "\t\tDATE_FORMAT(resappointment.dateToVisit, '%m-01-%Y') as date,\n"
				+ "\t\t\t\tspeciality,\n" + "\t\tcount(*) as count\n" + "\t\tfrom resappointment\n"
				+ "\t\tgroup by speciality,DATE_FORMAT(resappointment.dateToVisit, '%m-%Y')\n"
				+ "\t\torder by speciality,YEAR(resappointment.dateToVisit),MONTH(resappointment.dateToVisit);";

		Query query = entityManager.createNativeQuery(queryString);
		NativeQueryImpl nativeQuery = (NativeQueryImpl) query;
		nativeQuery.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
		List<Map<String,Object>> result = nativeQuery.getResultList();
		return result;
	}

	public List<?> getThisYearSpecialitiesPercentageCount()
	{
		String queryString = "select\n" + "       speciality,\n" + "       count(*) as count,\n"
				+ "       count(*) *100 /(select count(*) from resappointment where year(resappointment.dateToVisit) = year(curdate())) as percentage\n"
				+ "from resappointment\n"
				+ "where year(resappointment.dateToVisit) = year(curdate()) and resappointment.status = 'Invoiced'\n"
				+ "\t\t\t\tgroup by speciality\n" + "\t\t\t\torder by speciality;";

		Query query = entityManager.createNativeQuery(queryString);
		NativeQueryImpl nativeQuery = (NativeQueryImpl) query;
		nativeQuery.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
		List<Map<String,Object>> result = nativeQuery.getResultList();
		return result;
	}

	public List<?> getThisYearSpecialitiesPercentageIncome()
	{
		String queryString = "select\n" + "       speciality,\n" + "       sum(inv.totalAfterDiscount) as income,\n"
				+ "    sum(inv.totalAfterDiscount) *100 /(\n" + "        select sum(inv.totalAfterDiscount)\n"
				+ "        from resappointment inner join resinvoice inv on inv.appointmentCode = resappointment.code\n"
				+ "        where year(resappointment.dateToVisit) = year(curdate()) and (inv.status='Finalized' or inv.status='Debt')\n"
				+ "        ) as percentage\n" + "from resappointment app\n"
				+ "inner join resinvoice inv on app.code = inv.appointmentCode\n"
				+ "where year(app.dateToVisit) = year(curdate()) and (inv.status='Finalized' or inv.status='Debt')\n"
				+ "group by speciality\n" + "order by speciality;";

		Query query = entityManager.createNativeQuery(queryString);
		NativeQueryImpl nativeQuery = (NativeQueryImpl) query;
		nativeQuery.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
		List<Map<String,Object>> result = nativeQuery.getResultList();
		return result;
	}

	public List<?> getMonthlyInventoryInOut()
	{
		String queryString = "select DATE_FORMAT(ord.orderDate, '%m-01-%Y') as date,ord.type,sum(ord.totalPrice) as total\n"
				+ "from resinventoryorder ord\n" + "group by ord.type,DATE_FORMAT(ord.orderDate, '%m-01-%Y')\n"
				+ "order by ord.type,YEAR(ord.orderDate),MONTH(ord.orderDate);";

		Query query = entityManager.createNativeQuery(queryString);
		NativeQueryImpl nativeQuery = (NativeQueryImpl) query;
		nativeQuery.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
		List<Map<String,Object>> result = nativeQuery.getResultList();
		return result;
	}
}

