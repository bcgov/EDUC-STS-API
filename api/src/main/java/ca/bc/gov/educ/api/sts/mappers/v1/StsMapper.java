package ca.bc.gov.educ.api.sts.mappers.v1;

import ca.bc.gov.educ.api.sts.mappers.LocalDateTimeMapper;
import ca.bc.gov.educ.api.sts.mappers.StringMapper;
import ca.bc.gov.educ.api.sts.mappers.UUIDMapper;
import ca.bc.gov.educ.api.sts.model.v1.ISDLoginRolesID;
import ca.bc.gov.educ.api.sts.struct.v1.ISDRole;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {UUIDMapper.class, LocalDateTimeMapper.class, StringMapper.class})
@SuppressWarnings("squid:S1214")
public interface StsMapper {

  /**
   * The constant mapper.
   */
  StsMapper mapper = Mappers.getMapper(StsMapper.class);

  /**
   * To isd role from isd login role.
   *
   * @param isdLoginRolesID the isd login roles id
   * @return the isd role
   */
  ISDRole toISDRole(ISDLoginRolesID isdLoginRolesID);
}
