import org.junit.Before;
import org.junit.Test;
import org.modelmapper.*;
import test.model.mapper.ParentClassA;
import test.model.mapper.ParentClassMap;
import test.model.mapper.SubClassB;
import test.model.mapper.SubClassBMap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;

/**
 * User: greg
 * Date: 13-07-22
 * Time: 10:28 AM
 */
public class TestTwoWayMap {

    private ParentClassA parentClassA;
    private SubClassB subClassB;


    @Before
    public void before(){
        parentClassA = new ParentClassA();
        subClassB = new SubClassB();
        subClassB.setParentClassA(parentClassA);

        parentClassA.addSubClassBs(subClassB);
    }

    @Test
    public void testTwoWayMapping(){

        ModelMapper modelMapper = new ModelMapper();
//        modelMapper.getConfiguration().setProvider(provider);
        modelMapper.addMappings(new ParentClassMap());
        modelMapper.addMappings(new SubClassBMap());

        ParentClassA map = modelMapper.map(parentClassA, ParentClassA.class);


        assertThat(map, is(not(parentClassA)));
        SubClassB mapOfSub = map.getSubClassBs().iterator().next();
        assertThat(mapOfSub, is(not(subClassB)));
        assertThat(mapOfSub.getParentClassA(), is(not(parentClassA)));

    }

    Provider<ParentClassA> provider = new AbstractProvider<ParentClassA>(){


        @Override
        protected ParentClassA get() {
            return new ParentClassA();
        }
    };



}
