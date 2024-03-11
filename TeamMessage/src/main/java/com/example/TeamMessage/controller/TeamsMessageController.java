/*package com.example.TeamMessage.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TeamsMessageController {

	@PostMapping("/send-message")
	public String sendMessageToTeams(@RequestBody String message) {
		String teamsWebhookUrl = "https://cbitcollege.webhook.office.com/webhookb2/10aa9d73-547f-4f01-b9af-cd83b4342a3e@8ba02f42-a433-4ad5-bdab-0103a1bc5fa5/IncomingWebhook/1f8072588d7e428e879204c88399da43/fa1e16ef-1bdd-4512-8259-6e622ee929b1";

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForObject(teamsWebhookUrl, message, String.class);

		return "Message sent to Microsoft Teams!";
	}
}*/
package com.example.TeamMessage.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TeamsMessageController {

	@PostMapping("/send-message/{channelId}")
	public String sendMessageToTeams(@RequestBody String message, @PathVariable("channelId") String channelId) {
		// Construct the webhook URL with the channel ID as a query parameter
		String teamsWebhookUrl = "https://cbitcollege.webhook.office.com/webhookb2/10aa9d73-547f-4f01-b9af-cd83b4342a3e@8ba02f42-a433-4ad5-bdab-0103a1bc5fa5/IncomingWebhook/1f8072588d7e428e879204c88399da43/fa1e16ef-1bdd-4512-8259-6e622ee929b1?channelId="
				+ channelId;

		// Create a RestTemplate instance
		RestTemplate restTemplate = new RestTemplate();

		// Send the message to the Teams channel
		restTemplate.postForObject(teamsWebhookUrl, message, String.class);

		return "Message sent to Microsoft Teams channel ID: " + channelId;
	}
}
