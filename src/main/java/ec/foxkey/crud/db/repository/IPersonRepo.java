package ec.foxkey.crud.db.repository;

import ec.foxkey.crud.db.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPersonRepo extends JpaRepository<Person, String> {

}
