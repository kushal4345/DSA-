package Graph;

import java.util.*;

public class recepie {

    public static void main(String[] args) {

        String[] recipes = {"bread", "sandwich"};
        String[][] ingredients = {
                {"yeast", "flour"},
                {"bread", "meat"}
        };
        String[] supplies = {"yeast", "flour", "meat"};

        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> indegree = new HashMap<>();

        // Build graph and indegree
        for (int i = 0; i < recipes.length; i++) {
            indegree.put(recipes[i], ingredients[i].length);

            for (String ing : ingredients[i]) {
                graph.computeIfAbsent(ing, k -> new ArrayList<>()).add(recipes[i]);
            }
        }

        Queue<String> q = new LinkedList<>();

        for (String supply : supplies) {
            q.offer(supply);
        }

        List<String> ans = new ArrayList<>();

        while (!q.isEmpty()) {
            String item = q.poll();

            if (!graph.containsKey(item))
                continue;

            for (String recipe : graph.get(item)) {
                indegree.put(recipe, indegree.get(recipe) - 1);

                if (indegree.get(recipe) == 0) {
                    ans.add(recipe);
                    q.offer(recipe);
                }
            }
        }

        System.out.println(ans);
    }
}