class Twitter {
    HashMap<Integer, HashSet<Integer>> followList = new HashMap<>();
    HashMap<Integer, List<int[]>> tweetList = new HashMap<>();
    int time = 0;

    public Twitter() {
        
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetList.computeIfAbsent(userId, k -> new ArrayList<>()).add(new int[] {tweetId, time++});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[3] - a[3]);
        HashSet<Integer> hs = new HashSet<>();
        hs.add(userId);
        hs.addAll(followList.getOrDefault(userId, new HashSet<>()));
        
        for (int i : hs) {
            List<int[]> list = tweetList.get(i);

            if (list == null) continue;

            int[] tweet = list.get(list.size() - 1);
            pq.offer(new int[] {i, list.size() - 1, tweet[0], tweet[1]});
        }

        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty() && res.size() < 10) {
            int[] node = pq.poll();
            res.add(node[2]);

            if (node[1] > 0) {
                List<int[]> list = tweetList.get(node[0]);
                int[] tweet = list.get(node[1] - 1);
                pq.offer(new int[] {node[0], node[1] - 1, tweet[0], tweet[1]});
            }
        }

        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        followList.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        HashSet<Integer> list = followList.get(followerId);

        if (list != null) {
            list.remove(followeeId);
        }
    }
}
