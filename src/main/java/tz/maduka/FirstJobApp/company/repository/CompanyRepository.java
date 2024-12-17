package tz.maduka.FirstJobApp.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tz.maduka.FirstJobApp.company.model.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
