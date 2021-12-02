package ca.bc.gov.educ.api.sts.repository.v1;

import ca.bc.gov.educ.api.sts.model.v1.ISDLoginRolesID;
import ca.bc.gov.educ.api.sts.model.v1.ISDLoginRolesView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The interface Isd login roles view repository.
 */
@Repository
public interface ISDLoginRolesViewRepository extends JpaRepository<ISDLoginRolesView, ISDLoginRolesID> {
  /**
   * Find all by isd login roles id list.
   *
   * @param isdLoginRolesID the isd login roles id
   * @return the list
   */
  List<ISDLoginRolesView> findAllByIsdLoginRolesID(ISDLoginRolesID isdLoginRolesID);
}
