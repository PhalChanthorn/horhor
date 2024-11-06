package com.setec.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;


import lombok.Data;

@Service
@Data
public class Mytelegrambot {
	
	@Value("${telegram_token}")
	private String telegram_token;
	
	@Value("${chat_id}")
	private long chat_id;
	
	private TelegramBot bot;
	
	public SendResponse sendMessage(String message) {
		if(bot==null)
			bot = new TelegramBot(telegram_token);
		SendResponse send = bot.execute(new SendMessage(chat_id, message));
		
		return send;
		
	}

	
	
	
	
	
}
