package com.socialnmobile.colornote.sync.jobs.listeners;

import com.socialnmobile.colornote.sync.ai;
import com.socialnmobile.colornote.sync.errors.PasswordNotMatch.Listener;
import com.socialnmobile.colornote.sync.jobs.AuthJob;

public interface EmailReloginListener extends ai, Listener, AuthJob.Listener {
}
