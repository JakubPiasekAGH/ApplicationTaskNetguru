# ApplicationTaskNetguru

Looking for 2 core functionalities in twitter I've started with quick research and according to wikipedia Twitter is: 
"an (..) service on which users post and interact with messages known as "tweets". Registered users can post, like and retweet tweets, but unregistered users can only read them.".

As I can imagine for twitter owners more important are registered users that spend a lot of time in this social service, so I decided to test 2 functionalities that are available only for registered users. In order to achieve it I've created a test account without any tweets/followers/etc.

In tests I implement two scenarios for 2 different type of user:
1. 'active user' - after logging into service user post and public a tweet. Then user realize that there is a spelling mistake and delete a tweet (because editing is not possible). In my opinion 'post' tweet and 'delete' tweet responds to first key functionality of twitter "users can post") and I think I can add a small extension here with e.g posting tweet that contains picture - as a user of twitter I mostly care about tweets with multimedia added. [Post will have default settings so it means it will go 'public']

2. 'passive user' - after logging into service user search for tweet, navigate to newest tweet found, put like below tweet, add comment, remove comment, remove like and finish interaction with site. So in this scenario I will check second core functionality of twitter - allowing for interaction between users by giving 'likes' and adding comments. 

For this 2 scenarios I've created 2 independent test classes and 2 independent user accounts. I've applied to tweeter for 'developer accounts' for this tests however I can imagine that they won't manage to give that kind of access to me before deadline of this task. If this happen won't happen there may be some troubles to execute tests (twitter block 'bot' accounts). If that will appear (I hope not, but it's possible) there will be a need to create 2 different twitter account and pass them as property to executing tests (more about this later).

As i got 2 different test classes I've created 2 users I decided to make everything run faster and run tests from mvn in parallel. Unfortunately there is known surefire plugin issue with collecting results of parallel run (https://issues.apache.org/jira/browse/SUREFIRE-1643) so I set up the tests to run one by one. If you want to start them parallel add:
-Djunit.jupiter.execution.parallel.mode.classes.default=concurrent

Test scenario 1:

class TwitterPostingTest:

1. Preconditions -> log in to twitter with credentials from test.properties file -Dposting.user.name=user_automation and -Dposting.user.password=1234Qwerty

void publicTweetWithPicture():
2. Add new tweet:
	- add text (At the end of tweet I've added a timestamp to make sure that we are verifying newly added tweet not something that may be left from previous test runs)
	- insert imageto scrach of tweet,
	- check number of tweets (to make sure that newly added twitt appear),
	- click 'tweet' button (public your tweet)
	- wait for newly tweet to appear (number of tweets must increment)
3. Verify:
	- verify if new tweet appeared on you board,
	- verify if new tweet text equals text you entered,
	- verify if new tweet image equals the image you've added.
	(all verification is closed in assertAll() block so it means that even if one of this conditions fails, all of them will be verified anyway).

void deleteTweetWithPicture()
4. Get number of tweets available on you board
5. Remove tweet (options, delete, confirm delete),
6. Wait for number of tweets to decrement
7. Verify:
	- verify if number of tweets after removing tweet is decremented by 1,
	- verify if text from first available tweet on board does not equal the text of tweet that you added