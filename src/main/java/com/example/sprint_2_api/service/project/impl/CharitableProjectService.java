package com.example.sprint_2_api.service.project.impl;

import com.example.sprint_2_api.dto.chart.Chart;
import com.example.sprint_2_api.dto.chart.ChartByDay;
import com.example.sprint_2_api.dto.project.ProjectDto;
import com.example.sprint_2_api.model.project.CharitableProject;
import com.example.sprint_2_api.repository.project.ICharitableProjectRepository;
import com.example.sprint_2_api.service.project.ICharitableProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.YearMonth;
import java.util.*;

@Service
public class CharitableProjectService implements ICharitableProjectService {

    @Autowired
    private ICharitableProjectRepository charitableProjectRepository;

    @Override
    public List<CharitableProject> findAll() {
        return charitableProjectRepository.findAll();
    }

    @Override
    public Optional<CharitableProject> findById(Long id) {
        return charitableProjectRepository.findById(id);
    }

    @Override
    public void save(CharitableProject charitableProject) {
        charitableProjectRepository.save(charitableProject);
    }

    @Override
    public void remove(Long id) {
        charitableProjectRepository.deleteById(id);
    }

    @Override
    public Page<CharitableProject> findAll(Pageable pageable) {
        return charitableProjectRepository.findAll(pageable);
    }

    @Override
    public Page<ProjectDto> findAllByCard(Pageable pageable) {
        return charitableProjectRepository.findAllByCard(pageable);
    }

    @Override
    public Page<ProjectDto> findAllByCardWithType(Pageable pageable, Long id) {
        return charitableProjectRepository.findAllByCardWithType(pageable, id);
    }

    @Override
    public Page<ProjectDto> findAllByCardWithSearch(Pageable pageable, String value) {
        return charitableProjectRepository.findAllByCardWithSearch(pageable, "%" + value + "%");
    }

    @Override
    public Page<ProjectDto> findAllByCardOther(Pageable pageable, int limit) {
        if (limit == 1) {
            return charitableProjectRepository.findAllByCardOther1(pageable);
        } else {
            return charitableProjectRepository.findAllByCardOther3(pageable);
        }
    }

    public Map<Long, Long> mapChartDay() {
        List<Chart> list = charitableProjectRepository.chartToDay();
        Map<Long, Long> map = new HashMap<>();
        for (Chart chart : list) {
            map.put(chart.getId(), chart.getMoney());
        }
        return map;
    }

    public Map<Long, Long> mapChartMonth() {
        List<Chart> list = charitableProjectRepository.chartToMonth();
        Map<Long, Long> map = new HashMap<>();
        for (Chart chart : list) {
            map.put(chart.getId(), chart.getMoney());
        }
        return map;
    }

    @Override
    public List<List<Long>> mapChartTypeMonth() {
        List<Chart> list = charitableProjectRepository.chartToMonth();
        Map<Long, Long> mapCount = new TreeMap<>();
        Map<Long, Long> mapMoney = new TreeMap<>();
        for (Chart chart : list) {
            if (mapCount.containsKey(chart.getTypeId())) {
                mapCount.put(chart.getTypeId(), mapCount.get(chart.getTypeId()) + 1);
                mapMoney.put(chart.getTypeId(), mapMoney.get(chart.getTypeId()) + chart.getMoney());
            } else {
                mapCount.put(chart.getTypeId(), 1L);
                mapMoney.put(chart.getTypeId(), chart.getMoney());
            }
        }
        List<Long> longsCount = new ArrayList<>();
        List<Long> longsMoney = new ArrayList<>();
        mapCount.forEach((key, value) -> longsCount.add(value));
        mapMoney.forEach((key, value) -> longsMoney.add(value));
        List<List<Long>> longs = new ArrayList<>();
        longs.add(longsCount);
        longs.add(longsMoney);
        return longs;
    }

    @Override
    public void changeStatus(Long id) {
        CharitableProject charitableProject = charitableProjectRepository.getById(id);
        if (charitableProject.getNow() > charitableProject.getTarget()) {
            charitableProject.setStatus(1);
            charitableProjectRepository.save(charitableProject);
        }
    }

    @Override
    public Long countOfToDay() {
        Map<Long, Long> map = mapChartDay();
        return (long) map.size();
    }

    @Override
    public Long sumMoneyOfToDay() {
        Map<Long, Long> map = mapChartDay();
        long[] sum = {0};
        map.forEach((key, value) -> sum[0] += value);
        return sum[0];
    }

    @Override
    public Long countOfMonth() {
        Map<Long, Long> map = mapChartMonth();
        return (long) map.size();
    }

    @Override
    public Long sumMoneyOfMonth() {
        Map<Long, Long> map = mapChartMonth();
        long[] sum = {0};
        map.forEach((key, value) -> sum[0] += value);
        return sum[0];
    }

    @Override
    public List<List<Long>> listByDay() {
        YearMonth yearMonth = YearMonth.now();
        int daysInMonth = yearMonth.lengthOfMonth();
        List<List<Long>> lists = new ArrayList<>();
        List<ChartByDay> count = charitableProjectRepository.listCountByDay();
        List<ChartByDay> money = charitableProjectRepository.listMoneyByDay();
        lists.add(new ArrayList<>());
        lists.add(new ArrayList<>());
        boolean flag = true;
        for (int i = 0; i < daysInMonth; i++) {
            for (int j = 0; j < count.size(); j++) {
                if (i + 1 == count.get(j).getDay()) {
                    lists.get(0).add(count.get(j).getCount());
                    lists.get(1).add(money.get(j).getMoney());
                    flag = false;
                    break;
                }
            }
            if (flag) {
                lists.get(0).add(0L);
                lists.get(1).add(0L);
            }
            flag = true;
        }
        return lists;
    }
}
