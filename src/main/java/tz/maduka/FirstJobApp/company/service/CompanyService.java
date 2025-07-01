package tz.maduka.FirstJobApp.company.service;

import tz.maduka.FirstJobApp.company.model.Company;
import tz.maduka.FirstJobApp.company.payload.rest.dto.CompanyDto;

import java.util.List;

public interface CompanyService {

    List<Company> getAllCompanies();
    boolean createCompany(CompanyDto companyDto);
    boolean updateCompany(CompanyDto companyDto, Long id);
    boolean deleteCompany(Long id);
    Company getCompanyById(Long id);
}
