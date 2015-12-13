package com.bau.hotel;

import com.bau.hotel.dao.EntryDao;
import com.bau.hotel.model.Entry;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainControllerTest {

    private MainController controller = new MainController();

    @Test
    public void shouldReturnIndexPage() {
        EntryDao mock = Mockito.mock(EntryDao.class);
        controller.setEntryDao(mock);

        ModelAndView mav = controller.index();
        assertThat(mav.getViewName(), equalTo("index"));
    }

    @Test
    public void shouldIndexPageContainBlogEntries() {
        List<Entry> entryList = new ArrayList<>();
        entryList.add(new Entry());

        EntryDao mock = Mockito.mock(EntryDao.class);
        controller.setEntryDao(mock);

        Mockito.when(mock.getEntries()).thenReturn(entryList);

        ModelAndView mav = controller.index();
        Object entries = mav.getModel().get("entries");

        assertThat(entries, equalTo(entryList));
    }
}