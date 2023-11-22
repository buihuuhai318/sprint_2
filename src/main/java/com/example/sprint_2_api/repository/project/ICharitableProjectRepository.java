package com.example.sprint_2_api.repository.project;

import com.example.sprint_2_api.dto.chart.Chart;
import com.example.sprint_2_api.dto.chart.ChartByDay;
import com.example.sprint_2_api.dto.project.ProjectDto;
import com.example.sprint_2_api.model.project.CharitableProject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICharitableProjectRepository extends JpaRepository<CharitableProject, Long> {

    @Override
    Page<CharitableProject> findAll(Pageable pageable);

    @Query(value = "select cp.id as id, cp.title as title, max(pi.name) as projectImage, c.name as company, ci.name as companyImage, cp.count as count, cp.now as now, cp.target as targetLimit, datediff(cp.end_date, curdate()) as date, cp.status as status, c.id as companyId " +
            "from charitable_project cp " +
            "join company c on cp.company_id = c.id " +
            "join company_image ci on c.image_id = ci.id " +
            "join project_image pi on pi.project_id = cp.id " +
            "group by cp.id, cp.title, c.name, ci.name, cp.count, cp.now, cp.target " +
            "having max(pi.name) is not null ", nativeQuery = true)
    Page<ProjectDto> findAllByCard(Pageable pageable);

    @Query(value = "select cp.id as id, cp.title as title, max(pi.name) as projectImage, c.name as company, ci.name as companyImage, cp.count as count, cp.now as now, cp.target as targetLimit, datediff(cp.end_date, curdate()) as date, cp.status as status, c.id as companyId " +
            "from charitable_project cp " +
            "join company c on cp.company_id = c.id " +
            "join project_type pt on cp.id = pt.project_id " +
            "join charitable_type ct on pt.type_id = ct.id " +
            "join company_image ci on c.image_id = ci.id " +
            "join project_image pi on pi.project_id = cp.id " +
            "where ct.id = :id " +
            "group by cp.id, cp.title, c.name, ci.name, cp.count, cp.now, cp.target " +
            "having max(pi.name) is not null ", nativeQuery = true)
    Page<ProjectDto> findAllByCardWithType(Pageable pageable, Long id);

    @Query(value = "select cp.id as id, cp.title as title, max(pi.name) as projectImage, c.name as company, ci.name as companyImage, cp.count as count, cp.now as now, cp.target as targetLimit, datediff(cp.end_date, curdate()) as date, cp.status as status, c.id as companyId " +
            "from charitable_project cp " +
            "join company c on cp.company_id = c.id " +
            "join project_type pt on cp.id = pt.project_id " +
            "join charitable_type ct on pt.type_id = ct.id " +
            "join company_image ci on c.image_id = ci.id " +
            "join project_image pi on pi.project_id = cp.id " +
            "where c.id = :id " +
            "group by cp.id, cp.title, c.name, ci.name, cp.count, cp.now, cp.target " +
            "having max(pi.name) is not null ", nativeQuery = true)
    Page<ProjectDto> findAllByCardWithCompany(Pageable pageable, Long id);

    @Query(value = "select cp.id as id, cp.title as title, max(pi.name) as projectImage, c.name as company, ci.name as companyImage, cp.count as count, cp.now as now, cp.target as targetLimit, datediff(cp.end_date, curdate()) as date, cp.status as status, c.id as companyId " +
            "from charitable_project cp " +
            "join company c on cp.company_id = c.id " +
            "join project_type pt on cp.id = pt.project_id " +
            "join charitable_type ct on pt.type_id = ct.id " +
            "join company_image ci on c.image_id = ci.id " +
            "join project_image pi on pi.project_id = cp.id " +
            "where title like :value or c.name like :value " +
            "group by cp.id, cp.title, c.name, ci.name, cp.count, cp.now, cp.target " +
            "having max(pi.name) is not null ", nativeQuery = true)
    Page<ProjectDto> findAllByCardWithSearch(Pageable pageable, String value);

    @Query(value = "select cp.id as id, cp.title as title, max(pi.name) as projectImage, c.name as company, ci.name as companyImage, cp.count as count, cp.now as now, cp.target as targetLimit, datediff(cp.end_date, curdate()) as date, cp.status as status, c.id as companyId " +
            "from charitable_project cp " +
            "join company c on cp.company_id = c.id " +
            "join project_type pt on cp.id = pt.project_id " +
            "join charitable_type ct on pt.type_id = ct.id " +
            "join company_image ci on c.image_id = ci.id " +
            "join project_image pi on pi.project_id = cp.id " +
            "where cp.status = 0 " +
            "group by cp.id, cp.title, c.name, ci.name, cp.count, cp.now, cp.target " +
            "having max(pi.name) is not null order by date asc ", nativeQuery = true)
    Page<ProjectDto> findAllByCardOther1(Pageable pageable);

    @Query(value = "select cp.id as id, cp.title as title, max(pi.name) as projectImage, c.name as company, ci.name as companyImage, cp.count as count, cp.now as now, cp.target as targetLimit, datediff(cp.end_date, curdate()) as date, cp.status as status, c.id as companyId " +
            "from charitable_project cp " +
            "join company c on cp.company_id = c.id " +
            "join project_type pt on cp.id = pt.project_id " +
            "join charitable_type ct on pt.type_id = ct.id " +
            "join company_image ci on c.image_id = ci.id " +
            "join project_image pi on pi.project_id = cp.id " +
            "where cp.status = 0 " +
            "group by cp.id, cp.title, c.name, ci.name, cp.count, cp.now, cp.target " +
            "having max(pi.name) is not null order by date desc ", nativeQuery = true)
    Page<ProjectDto> findAllByCardOther3(Pageable pageable);

    @Query(value = "SELECT " +
            "    c.id AS id, " +
            "    cp.title AS title, " +
            "    c.create_date AS date, " +
            "    c.money AS money, " +
            "    cp.id AS projectId, " +
            "    ct.id AS typeId " +
            "FROM " +
            "    cart c " +
            "JOIN " +
            "    charitable_project cp ON c.charitable_project_id = cp.id " +
            "JOIN " +
            "    project_type pt ON pt.project_id = cp.id " +
            "JOIN " +
            "    charitable_type ct ON ct.id = pt.type_id " +
            "WHERE " +
            "    c.pay_status = 1 AND " +
            "    DATE(c.create_date) = CURRENT_DATE() " +
            "ORDER BY " +
            "    c.id ", nativeQuery = true)
    List<Chart> chartToDay();

    @Query(value = "SELECT " +
            "    c.id AS id, " +
            "    cp.title AS title, " +
            "    c.create_date AS date, " +
            "    c.money AS money, " +
            "    cp.id AS projectId, " +
            "    ct.id AS typeId " +
            "FROM " +
            "    cart c " +
            "JOIN " +
            "    charitable_project cp ON c.charitable_project_id = cp.id " +
            "JOIN " +
            "    project_type pt ON pt.project_id = cp.id " +
            "JOIN " +
            "    charitable_type ct ON ct.id = pt.type_id " +
            "WHERE " +
            "    c.pay_status = 1 AND " +
            "    MONTH(c.create_date) = MONTH(CURRENT_DATE()) " +
            "ORDER BY " +
            "    ct.id ", nativeQuery = true)
    List<Chart> chartToMonth();

    @Query(value = "SELECT " +
            "    dates.day, " +
            "    COALESCE(SUM(c.money), 0) AS money " +
            "FROM ( " +
            "    SELECT 1 AS day " +
            "    UNION SELECT 2 UNION SELECT 3 UNION SELECT 4 UNION SELECT 5 UNION SELECT 6 " +
            "    UNION SELECT 7 UNION SELECT 8 UNION SELECT 9 UNION SELECT 10 UNION SELECT 11 " +
            "    UNION SELECT 12 UNION SELECT 13 UNION SELECT 14 UNION SELECT 15 UNION SELECT 16 " +
            "    UNION SELECT 17 UNION SELECT 18 UNION SELECT 19 UNION SELECT 20 UNION SELECT 21 " +
            "    UNION SELECT 22 UNION SELECT 23 UNION SELECT 24 UNION SELECT 25 UNION SELECT 26 " +
            "    UNION SELECT 27 UNION SELECT 28 UNION SELECT 29 UNION SELECT 30 UNION SELECT 31 " +
            ") AS dates " +
            "LEFT JOIN cart c ON dates.day = DAY(c.create_date) " +
            "    AND YEAR(c.create_date) = YEAR(CURDATE()) " +
            "    AND MONTH(c.create_date) = MONTH(CURDATE()) " +
            "    AND c.pay_status = 1 " +
            "JOIN charitable_project cp ON c.charitable_project_id = cp.id " +
            "GROUP BY " +
            "    dates.day ", nativeQuery = true)
    List<ChartByDay> listMoneyByDay();


    @Query(value = "SELECT " +
            "    dates.day, " +
            "    COALESCE(COUNT(c.id), 0) AS count " +
            "FROM ( " +
            "    SELECT 1 AS day " +
            "    UNION SELECT 2 UNION SELECT 3 UNION SELECT 4 UNION SELECT 5 UNION SELECT 6 " +
            "    UNION SELECT 7 UNION SELECT 8 UNION SELECT 9 UNION SELECT 10 UNION SELECT 11 " +
            "    UNION SELECT 12 UNION SELECT 13 UNION SELECT 14 UNION SELECT 15 UNION SELECT 16 " +
            "    UNION SELECT 17 UNION SELECT 18 UNION SELECT 19 UNION SELECT 20 UNION SELECT 21 " +
            "    UNION SELECT 22 UNION SELECT 23 UNION SELECT 24 UNION SELECT 25 UNION SELECT 26 " +
            "    UNION SELECT 27 UNION SELECT 28 UNION SELECT 29 UNION SELECT 30 UNION SELECT 31 " +
            ") AS dates " +
            "LEFT JOIN cart c ON dates.day = DAY(c.create_date) " +
            "    AND YEAR(c.create_date) = YEAR(CURDATE()) " +
            "    AND MONTH(c.create_date) = MONTH(CURDATE()) " +
            "    AND c.pay_status = 1 " +
            "JOIN charitable_project cp ON c.charitable_project_id = cp.id " +
            "GROUP BY " +
            "    dates.day ", nativeQuery = true)
    List<ChartByDay> listCountByDay();

    CharitableProject getById(Long id);
}
