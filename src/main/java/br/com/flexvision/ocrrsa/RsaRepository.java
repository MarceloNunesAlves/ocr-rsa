package br.com.flexvision.ocrrsa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RsaRepository extends CrudRepository<Rsa, String>  {

}
