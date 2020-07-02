package ec.foxkey.crud.db.repository;

import ec.foxkey.crud.db.entities.Logs;
import ec.foxkey.crud.db.entities.Statistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ILogsRepo extends JpaRepository<Logs, Integer> {
    List<Logs> getAllByType(int type);

    Integer countByType(int type);

    Void deleteByType(int type);

    @Query(value = "select date_part('month', day) from logs group by 1 order by 1",
            nativeQuery = true)
    List<Integer> getMonths();

    @Query(value = "select date_part('month', day) as Nmonth, count(1) as Process from logs where type = ?1 group by 1",
            nativeQuery = true)
    List<Statistics> findAllProcess(Integer type);
}
