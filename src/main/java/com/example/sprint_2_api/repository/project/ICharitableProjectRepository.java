package com.example.sprint_2_api.repository.project;

import com.example.sprint_2_api.dto.project.ProjectDto;
import com.example.sprint_2_api.model.project.CharitableProject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ICharitableProjectRepository extends JpaRepository<CharitableProject, Long> {

    @Override
    Page<CharitableProject> findAll(Pageable pageable);

    @Query(value = "select cp.id as id, cp.title as title, max(pi.name) as projectImage, c.name as company, ci.name as companyImage, cp.count as count, cp.now as now, cp.target as targetLimit, datediff(cp.end_date, cp.create_date) as date " +
            "from charitable_project cp " +
            "join company c on cp.company_id = c.id " +
            "join company_image ci on c.image_id = ci.id " +
            "join project_image pi on pi.project_id = cp.id " +
            "group by cp.id, cp.title, c.name, ci.name, cp.count, cp.now, cp.target " +
            "having max(pi.name) is not null", nativeQuery = true)
    Page<ProjectDto> findAllByCard(Pageable pageable);
}
