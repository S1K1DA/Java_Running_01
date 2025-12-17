package team;

import champion.Champion;

import java.util.HashMap;
import java.util.Map;

public class ChampionPool {

    private Map<String, Champion> pool = new HashMap<>();

    // 챔피언 추가
    public void addChampion(Champion champion) {
        pool.put(champion.getName(), champion);
    }

    // 이름 닉네임으로 챔피언 조회
    public Champion get(String name) {
        return pool.get(name);
    }

    // 존재 여부 체크
    public boolean exists(String name) {
        return pool.containsKey(name);
    }
}
