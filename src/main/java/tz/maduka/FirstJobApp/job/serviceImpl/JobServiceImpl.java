package tz.maduka.FirstJobApp.job.serviceImpl;

import org.springframework.stereotype.Service;
import tz.maduka.FirstJobApp.company.model.Company;
import tz.maduka.FirstJobApp.company.repository.CompanyRepository;
import tz.maduka.FirstJobApp.job.model.Job;
import tz.maduka.FirstJobApp.job.payload.rest.dto.JobDto;
import tz.maduka.FirstJobApp.job.repository.JobRepository;
import tz.maduka.FirstJobApp.job.service.JobService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {

    private JobRepository jobRepository;
    private CompanyRepository companyRepository;

    public JobServiceImpl(JobRepository jobRepository, CompanyRepository companyRepository) {
        this.jobRepository = jobRepository;
        this.companyRepository = companyRepository;
    }

    //    List<Job> jobs = new ArrayList<>();

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob(JobDto jobDto) {
        Job newJob = new Job();
        Optional<Company> companyOptional = companyRepository.findById(jobDto.getCompany());
        if (companyOptional.isPresent()){
            Company instance = companyOptional.get();
            newJob.setTitle(jobDto.getTitle());
            newJob.setDescription(jobDto.getDescription());
            newJob.setMinSalary(jobDto.getMinSalary());
            newJob.setMaxSalary(jobDto.getMaxSalary());
            newJob.setLocation(jobDto.getLocation());
            newJob.setCompany(instance);
            jobRepository.save(newJob);
        }else {
            newJob.setTitle(jobDto.getTitle());
            newJob.setDescription(jobDto.getDescription());
            newJob.setMinSalary(jobDto.getMinSalary());
            newJob.setMaxSalary(jobDto.getMaxSalary());
            newJob.setLocation(jobDto.getLocation());
            jobRepository.save(newJob);
        }
    }

    @Override
    public Job getJobById(Long id) {

        return jobRepository.findById(id).orElse(null);
//        for(Job job : jobs){
//            if(job.getId().equals(id)){
//                return job;
//            }
//        }
//        return null;
    }

    @Override
    public boolean deleteJobById(Long id) {
        try {
            jobRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
//        Iterator<Job> iterator = jobs.iterator();
//        while (iterator.hasNext()){
//            Job job = iterator.next();
//            if(job.getId().equals(id)){
//                iterator.remove();
//                return true;
//            }
//        }
//        return false;
    }

    @Override
    public boolean updateJob(Long id, JobDto updatedJob) {

        try{
            Optional<Job> jobOptional = jobRepository.findById(id);
            if(jobOptional.isPresent()){
                Job job = jobOptional.get();
                job.setTitle(updatedJob.getTitle());
                job.setDescription(updatedJob.getDescription());
                job.setMinSalary(updatedJob.getMinSalary());
                job.setMaxSalary(updatedJob.getMaxSalary());
                 job.setLocation(updatedJob.getLocation());
                return true;
                }
        }catch (Exception e){
            return false;
            }
        return false;
//        for(Job job : jobs){
//            if(job.getId().equals(id)){
//                job.setTitle(updatedJob.getTitle());
//                job.setDescription(updatedJob.getDescription());
//                job.setMinSalary(updatedJob.getMinSalary());
//                job.setMaxSalary(updatedJob.getMaxSalary());
//                job.setLocation(updatedJob.getLocation());
//                return true;
//            }
//            return false;
//        }
//        return false;
    }
}
