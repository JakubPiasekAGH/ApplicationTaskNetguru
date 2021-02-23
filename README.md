#JavaSeleniumExample

Looking for 2 core functionalities in twitter I've started with quick research and according to wikipedia Twitter is: 
"an (..) service on which users post and interact with messages known as "tweets". Registered users can post, like and retweet tweets".
Another definition says:
"Twitter allows users to discover stories regarding today's biggest news and events, follow people or companies that post content they enjoy consuming, or simply communicate with friends."

As I can imagine for twitter owners more important are registered users that spend a lot of time in this social service, so I decided to test 2 functionalities that are available only for registered users. In order to achieve it I've created a test account without any tweets/followers/etc.

In tests I implement two scenarios for 2 different type of user:
1. 'active user' - after logging into service user create and public a tweet. Then delete a tweet. In my opinion 'post' tweet and 'delete' tweet responds to first key functionality of twitter ("users can post") and I think I can add a small extension here with e.g posting tweet that contains picture - as a user of twitter I mostly care about tweets with multimedia added. [Post will have default settings so it means it will go 'public']

2. 'passive user' - after logging into service user search for a page to follow, click follow button, verifies if page appeared as followed in profile, come back to page and un follow site (and verify again) 

For this 2 scenarios I've created 2 independent test classes and 2 independent user accounts. I've applied to tweeter for 'developer accounts' for this tests however I can imagine that they won't manage to give that kind of access to me before deadline of this task. If this won't happen there may be some troubles to execute tests (twitter block 'bot' accounts). If that will appear (I hope not, but it's possible) there will be a need to create 2 different twitter account and pass them as property to executing tests (more about this later).

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
	
	
Test scenario 2:

class TwitterFollowingTest:

1. Preconditions -> log in to twitter with credentials from test.properties file -Dfollowing.user.name=user_automation and -Dfollowing.user.password=1234Qwerty

void searchForFanPageAndFollow():
2. Search fan page:
	- enter text into search box,
	- wait for results listbox to appear,
	- click first search result,
	- wait for fan page to open and click 'Follow' button
3. Verify if 'Unfollow' button is displayed ('Follow' button changed state)

void verifyIfFollowedSiteAppearsInYourProfile()
4. Navigate to profile and verify if there is '1 Following'  label displayed

void verifyFollowedSiteList()
5. Click '1 Following' button and verify if there is exaclty one element on list

void unFollowFanPage()
6. Unfollow site and verify if there is not followed sites on list

void verifyIfUnFollowedSiteDoNotAppearsInYourProfile()
7. Verify if site was unfollowed and in your profile there is '0 Following' label displayed
 
void verifyUnFollowWithSiteList()
8. Go to followed site and verify if it's unfollowed

Install java11 (e.g. open JDK) and maven (if you do not have it) - https://www.baeldung.com/install-maven-on-windows-linux-mac

If installation is fine navigate to folder where you checkout project from repository (the one where there is pom.xml file)
Start cmd/terminal there and type 'mvn test' to run tests in default settings

If you want to edit settings and run the same tests in different configuration here are parameters that you can add to execution (listed with default settings):
-Dis.headless=false //can be set to 'false'
-Dwait.timeout=5 	//increment if internet connection is slow
-Dposting.user.name=user_automation		//username for TwitterPostingTest
-Dposting.user.password=1234Qwerty		//password for TwitterPostingTest
-Dfollowing.user.name=FollowingTests	//username for TwitterFollowingTest
-Dfollowing.user.password=Poiuyt67890	//password for TwitterFollowingTest
-Djunit.jupiter.execution.parallel.mode.default=same_thread //can be set to 'concurrent' (issue descripted above)

so with properties you can type in e.g cmd:
mvn -Dis.headless=true -Dwait.timeout=10 test
