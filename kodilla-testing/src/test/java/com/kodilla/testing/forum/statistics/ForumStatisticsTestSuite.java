package com.kodilla.testing.forum.statistics;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ForumStatisticsTestSuite {

    @BeforeAll
    public static void before() {
        System.out.println("Starting Tests");
    }

    private static int counter = 0;
    @BeforeEach
    public void beforeEveryTest() {
        counter++;
        System.out.println("Test No: " + counter);
    }

    @Mock
    private Statistics statisticsMock;

    private List<String> generateUserNames(int userNamesCount) {
        List<String> userName = new ArrayList<>();
        for (int i = 0; i < userNamesCount; i++) {
            String name = "a" + i;
            userName.add(name);
        }
        return userName;
    }

    @Nested
    @DisplayName("Advanced Statistic Test")
    class Test1 {
        @Test
        public void testCalculateAdvStatistics0Posts() {
            // Given
            ForumStatistics forumStatistics = new ForumStatistics();
            int posts = 0;
            when(statisticsMock.postsCount()).thenReturn(posts);
            // When
            forumStatistics.calculateAdvStatistics(statisticsMock);
            int postCount = forumStatistics.getPostsCount();
            // Then
            assertEquals(0, postCount);
        }

        @Test
        public void testCalculateAdvStatistics1000Posts() {
            ForumStatistics forumStatistics = new ForumStatistics();
            when(statisticsMock.postsCount()).thenReturn(1000);
            // When
            forumStatistics.calculateAdvStatistics(statisticsMock);
            int postCount = forumStatistics.getPostsCount();

            // Then
            assertEquals(1000, postCount);
        }

        @Test
        public void testCalculateAdvStatistics0Comments() {
            ForumStatistics forumStatistics = new ForumStatistics();
            when(statisticsMock.commentsCount()).thenReturn(0);
            // When
            forumStatistics.calculateAdvStatistics(statisticsMock);
            int commentCount = forumStatistics.getCommentsCount();

            // Then
            assertEquals(0, commentCount);
        }

        @Test
        public void testCalculateAdvStatisticsWhenCommentsMoreThanPosts() {
            ForumStatistics forumStatistics = new ForumStatistics();
            int mockCommentsCount = 15;
            int mockPostCount = 2;
            when(statisticsMock.commentsCount()).thenReturn(mockCommentsCount);
            when(statisticsMock.postsCount()).thenReturn(mockPostCount);

            // When
            forumStatistics.calculateAdvStatistics(statisticsMock);
            double averageCommentsPerPost = forumStatistics.getAverageCommentsPerPost();
            // Then
            assertEquals(7.5, averageCommentsPerPost);
        }

        @Test
        public void testCalculateAdvStatisticsWhenCommentsLessThanPosts() {
            ForumStatistics forumStatistics = new ForumStatistics();
            int mockCommentsCount = 4;
            int mockPostCount = 8;
            when(statisticsMock.commentsCount()).thenReturn(mockCommentsCount);
            when(statisticsMock.postsCount()).thenReturn(mockPostCount);

            // When
            forumStatistics.calculateAdvStatistics(statisticsMock);
            double averageCommentsPerPost = forumStatistics.getAverageCommentsPerPost();
            // Then
            assertEquals(0.5, averageCommentsPerPost);
        }

        @Test
        public void testCalculateAdvStatistics0Users() {
            ForumStatistics forumStatistics = new ForumStatistics();
            List<String> userName = new ArrayList<>();
            int mockCommentsCount = 4;
            int mockPostsCount = 8;
            when(statisticsMock.commentsCount()).thenReturn(mockCommentsCount);
            when(statisticsMock.postsCount()).thenReturn(mockPostsCount);
            // When
            forumStatistics.calculateAdvStatistics(statisticsMock);
            double averagePostsPerUser = forumStatistics.getAveragePostsPerUser();
            double averageCommentsPerUser = forumStatistics.getAveragePostsPerUser();
            // Then
            assertEquals(mockPostsCount / (double) userName.size(), averagePostsPerUser);
            assertEquals(mockCommentsCount / (double) userName.size(), averageCommentsPerUser);

        }

        @Test
        public void testCalculateAdvStatistics100Users() {
            ForumStatistics forumStatistics = new ForumStatistics();
            List<String> userName = generateUserNames(100);
            int mockCommentsCount = 4;
            int mockPostCount = 8;
            when(statisticsMock.commentsCount()).thenReturn(mockCommentsCount);
            when(statisticsMock.postsCount()).thenReturn(mockPostCount);
            when(statisticsMock.usersNames()).thenReturn(userName);
            // When
            forumStatistics.calculateAdvStatistics(statisticsMock);
            double averagePostsPerUser = forumStatistics.getAveragePostsPerUser();
            double averageCommentsPerUser = forumStatistics.getAverageCommentsPerUser();

            // Then
            assertEquals(100, userName.size());
            assertEquals(mockPostCount / (double) userName.size(), averagePostsPerUser);
            assertEquals(mockCommentsCount / (double) userName.size(), averageCommentsPerUser);
        }
    }

    @Nested
    @DisplayName("Show Statistic Test")
    class Test2 {
        @Test
        public void testShowStatistics() {
            // Given
            ForumStatistics forumStatistics = new ForumStatistics();
            // When
            StringBuilder sb = new StringBuilder();
            sb.append("Forum statistics:").append("\nUsers: ").append(forumStatistics.getUserNamesCount()).
                    append("Number of posts: ").append(forumStatistics.getPostsCount()).
                    append("Number of comments: ").append(forumStatistics.getCommentsCount()).
                    append("Comments per User: ").append(forumStatistics.getAverageCommentsPerUser()).
                    append("Posts per User: ").append(forumStatistics.getAverageCommentsPerUser()).
                    append("Comments per Count: ").append(forumStatistics.getAverageCommentsPerPost());
            String result = forumStatistics.showStatistics();
            // Then

            assertEquals(sb.toString(), result);
        }
    }
}
