# SlackBot - A Slackbot to Calculate User's Age (Java)

**Task 1:**
Creating a Slack Workspace for AgeBot Project
Use the code editor to write your code to finish this task

Step 1: Get started with slack

Slack is a collaboration platform that allows teams to communicate and work together in one place. Before integrating AgeBot into Slack, you'll need to create a Slack workspace. Here's a step-by-step guide to creating a Slack workspace for your AgeBot project:

1) Go to the Slack homepage at https://slack.com/ and click the "Get started for free" button.

2) Enter your email address and click "Create a new workspace."

3) Fill out the required information, such as your workspace name, and click "Create Workspace."

4) Follow the prompts to invite team members, set up channels, and customize your workspace. You can create channels for specific topics, invite team members to collaborate, and customize your workspace with themes and emojis.

5) Once you've finished setting up your workspace, you can start using Slack and integrating your AgeBot project into it. 

Step 2: Setting up the Slack Workspace for AgeBot Project

To integrate your AgeBot project with Slack, you will need to set up a Slack app and create a bot user. Here's how to set up your Slack workspace for the AgeBot project:

1) Go to the Slack API homepage at https://api.slack.com/ and click "Create an app" in the top right corner.

2) Select "From scratch" and enter a name for your app. Then, select the workspace you want to add your app to.

3) In the "Add features and functionality" section, click on "Bots" and then add bot scope 1. chat:write, im:history." This will enable your bot to write messages and access message history.

4) Give your bot a display name and default username. This will be the name that appears when the bot sends messages.

5) Click on "Install App" and then "Install App to Workspace." This will generate an OAuth Access Token that you can use to authenticate your app with the Slack API.

6) Copy the Bot User OAuth Access Token from the "OAuth & Permissions" page. This is your bot token and will be used to authorize your bot's communication with Slack.

7) To get your app token, click on "Basic Information" in the left-hand menu and then scroll down to "App-Level Tokens." Click "Create App-Level Token" and then add "connections:write" as a scope. Copy the newly created token.

8) Click on Socket Mode and enable Socket Mode. This allows your bot to receive events from Slack in real-time.

9) Add event subscription message:im to subscribe to message events sent to your bot.

10) Now that you have your bot token and app token, you can use them to authenticate your AgeBot project with the Slack API and start communicating with your bot in Slack.

By following these steps, you'll be able to set up a fully functional Slack workspace for your AgeBot project and start using it to calculate ages for users.

**Task 2:**
Creating a new Java project and integrating with Slack
Use the code editor to write your code to finish this task

To finish the project for the AgeBot, you'll need to follow these steps:

1) update the values for slack.app_token in project. 

2) Import the necessary Slack-related packages into your project using the import statement. You can use the Slack SDK for Go (https://github.com/slack-go/slack) to interact with the Slack API.

3) Integrate your Go project with Slack by initializing a new Slack API client using your Bot User OAuth Access Token and App-Level Token. You can use the New function provided by the Slack SDK to create a new instance of the Client struct.

4) Write the logic for calculating the age based on the provided date input. You can use the time package in Go to perform the necessary date calculations. First, parse the input date using the time.Parse function and then calculate the duration between the input date and the current date using the time.Since function. Finally, convert the duration to years and return the age as an integer.

5) Write a function that listens for incoming messages from Slack using the Client.AddMessageEvents function provided by the Slack SDK. When a message is received, parse the input date and calculate the age using the logic written in step 6. Then, use the Client.PostMessage function to send a response back to the user with their calculated age.
