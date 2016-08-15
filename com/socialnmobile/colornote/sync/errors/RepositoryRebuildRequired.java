package com.socialnmobile.colornote.sync.errors;

import com.socialnmobile.colornote.sync.p019c.C0369b;

public class RepositoryRebuildRequired extends ColorNoteRpcError {
    private static final long serialVersionUID = 7325471085360852407L;

    public interface Listener {
        void onError(RepositoryRebuildRequired repositoryRebuildRequired);
    }

    public RepositoryRebuildRequired(C0369b c0369b) {
        super(c0369b);
    }

    public RepositoryRebuildRequired(String str) {
        super(str);
    }
}
