package com.socialnmobile.colornote.sync.jobs.listeners;

import com.socialnmobile.colornote.sync.ag;
import com.socialnmobile.colornote.sync.errors.PasswordNotMatch.Listener;
import com.socialnmobile.colornote.sync.jobs.AuthJob;

public interface EmailLoginListener extends ag, Listener, AuthJob.Listener {
}
