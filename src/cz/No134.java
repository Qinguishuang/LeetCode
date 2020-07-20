package cz;

public class No134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0; // 起点
        int total = 0; // 从0-start需要多少油, 是个负数
        int tank = 0; // 从start到i需要的油

        for (int i = 0; i < gas.length; i++) {
            tank += (gas[i] - cost[i]); // 走过i剩下多少油
            if (tank < 0) { // 油不够了， start-i都不能做起点
                start = i + 1;
                total += tank;
                tank = 0;
            }
        }
        return total + tank >= 0 ? start : -1;
    }
}
