
package com.shecanfoundation.backend.repository;

import com.shecanfoundation.backend.entity.JoinForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JoinFormRepository
        extends JpaRepository<JoinForm, Long> {

}
