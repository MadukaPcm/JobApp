package tz.maduka.FirstJobApp.job.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tz.maduka.FirstJobApp.job.model.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {

}
