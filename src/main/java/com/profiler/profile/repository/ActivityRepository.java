package com.profiler.profile.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.profiler.profile.domain.Activity;

public interface ActivityRepository extends JpaRepository<Activity, Long> {

}
