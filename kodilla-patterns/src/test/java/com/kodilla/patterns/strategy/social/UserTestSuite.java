package com.kodilla.patterns.strategy.social;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTestSuite {

    private static User millenialUser = new Millenials("millenial");
    private static User YGenUser = new YGeneration("YGen");
    private static User ZGenUser = new ZGeneration("ZGen");


    @DisplayName("Default social media test")
    @Test
    public void testDefaultSharingStrategies() {
        // When & Then
        assertEquals(FacebookPublisher.class, millenialUser.socialPublisher.getClass());
        assertEquals(TwitterPublisher.class, YGenUser.socialPublisher.getClass());
        assertEquals(SnapchatPublisher.class, ZGenUser.socialPublisher.getClass());
    }

    @DisplayName("Individual social media test")
    @Test
    public void testIndividualSharingStrategy() {
        // Given
        User millenialUser1 = new Millenials("millenial1");

        // When
        TwitterPublisher twitter = new TwitterPublisher();
        millenialUser1.setSocialPublisher(twitter);

        // & Then
        assertEquals(TwitterPublisher.class, millenialUser1.socialPublisher.getClass());
   }

    @DisplayName("sharePost Test")
    @Test
    public void testSharePost() {
        //Given
        String post = "I'm back!";

        // When
        String result = millenialUser.sharePost(post);
        String expected = "millenial published on Facebook: I'm back!";

        // & Then
        assertEquals(expected, result);
    }
}

