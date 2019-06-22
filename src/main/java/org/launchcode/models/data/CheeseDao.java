package org.launchcode.models.data;

import org.launchcode.models.Cheese;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by LaunchCode
 */

@Repository // Create a concrete class that implements this interface.
@Transactional // All of the methods within this database should be wrapped by a database transaction.
public interface CheeseDao extends CrudRepository<Cheese, Integer> {

}
