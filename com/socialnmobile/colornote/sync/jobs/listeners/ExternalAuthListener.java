package com.socialnmobile.colornote.sync.jobs.listeners;

import com.socialnmobile.colornote.sync.errors.ExternalAuthFailed.Listener;
import com.socialnmobile.colornote.sync.jobs.AuthJob;

public interface ExternalAuthListener extends Listener, AuthJob.Listener {
}
