package com.socialnmobile.colornote.sync.jobs.listeners;

import com.socialnmobile.colornote.sync.ak;
import com.socialnmobile.colornote.sync.errors.BadFields.Listener;
import com.socialnmobile.colornote.sync.jobs.AuthJob;

public interface EmailSignupListener extends ak, Listener, AuthJob.Listener {
}
