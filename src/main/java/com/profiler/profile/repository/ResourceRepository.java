
package com.profiler.profile.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.profiler.profile.domain.Resource;

public interface ResourceRepository extends JpaRepository<Resource, Integer> {

}
