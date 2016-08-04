package br.com.spotippos.challenge;

import br.com.spotippos.challenge.service.SpotipposService;
import br.com.spotippos.challenge.service.impl.SpotipposServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by mtzcpd663 on 04/08/2016.
 */
public class SpotipposTest {

    private SpotipposService spotipposService;

    @Before
    public void init(){
        spotipposService = new SpotipposServiceImpl();
    }

    @Test
    public final void saveProperty(){
        Assert.assertNotNull(spotipposService);
    }
}
