package com.example.demo.service;

import java.util.Properties;

public record QueueSize(Properties queueProperties, long messageSize) {
}