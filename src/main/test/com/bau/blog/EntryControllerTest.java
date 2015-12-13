package com.bau.hotel;

import com.bau.hotel.dao.EntryDao;
import com.bau.hotel.model.Entry;
import com.bau.hotel.model.User;
import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import javax.servlet.http.HttpSession;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class EntryControllerTest {

    private EntryController controller = new EntryController();

    private EntryDao entryDao = Mockito.mock(EntryDao.class);

    private HttpSession session = Mockito.mock(HttpSession.class);

    @Before
    public void init(){
        controller.setEntryDao(entryDao);
    }

    @Test
    public void shouldAddEntry() {
        String title = "Heading";
        String content = "The Content";

        controller.addEntry(title, content, null, null, session);

        ArgumentCaptor<Entry> argumentCaptor = ArgumentCaptor.forClass(Entry.class);
        Mockito.verify(entryDao).addEntry(argumentCaptor.capture(), Mockito.any(User.class));

        Entry entry = argumentCaptor.getValue();
        assertThat(entry.getTitle(), equalTo(title));
        assertThat(entry.getEntry(), equalTo(content));
    }

    @Test
    public void shouldNoAddEntryWhenTitleIsInvalid(){
        String title = "";
        String content = "The Content";

        controller.addEntry(title, content, null, null, session);
        Mockito.verifyZeroInteractions(entryDao);
    }

    @Test
    public void shouldNoAddEntryWhenContentIsInvalid(){
        String title = "Heading";
        String content = "";

        controller.addEntry(title, content, null, null, session);
        Mockito.verifyZeroInteractions(entryDao);
    }

}