package com.example.service;

import com.example.dto.MovieDto;
import com.example.dto.TheaterDto;
import com.example.mappers.TheaterMapper;
import com.example.model.Movie;
import com.example.model.Theater;
import com.example.repository.TheaterRepo;
import com.example.util.MyLogger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;


import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
 public class TheaterServiceTest {

    @Mock
    TheaterRepo theaterRepo;
    @Mock
    TheaterMapper theaterMapper;
    @InjectMocks
    TheaterServiceImpl theaterService ;
    @Mock
    MyLogger logger;


    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
       // doNothing().when(logger).info(anyString());
    }
    Movie movie1 = new Movie(2,"Spider-Man","2","Action","English");
    Movie movie2 = new Movie(1,"Bombay to Goa","1","comedy","Hindi");
    MovieDto movieDto1 = new MovieDto(2,"Spider-Man","2","Action","English");
    MovieDto movieDto2 = new MovieDto(2,"Spider-Man","2","Action","English");
    List<Movie>movies = List.of(new Movie[]{movie1, movie2});
    List<MovieDto>movieDto = List.of(new MovieDto[]{movieDto1,movieDto2});

    Theater theater1 = new Theater.Builder("Big-cinemas").theaterId(1).address("pune").build();
    Theater theater2 = new Theater.Builder("pvr").theaterId(2).address("pune").build();
    TheaterDto theaterDto = new TheaterDto(1,"Big-cinemas","pune",movieDto);
    TheaterDto theaterDto1 = new TheaterDto(2,"PVR","pune",movieDto);
    @Test
public void getAllTheaterTest(){

    List<Theater> mockTheater = Arrays.asList(theater1,theater2);

    when(theaterRepo.findAll()).thenReturn(mockTheater);
    when(theaterMapper.toDto(theater1)).thenReturn(theaterDto);
    when(theaterMapper.toDto(theater2)).thenReturn(theaterDto1);

    List<TheaterDto>result = theaterService.getAllTheater();

    verify(theaterRepo,times(1)).findAll();
    verify(theaterMapper,times(1)).toDto(theater1);
    verify(theaterMapper,times(1)).toDto(theater2);

    Assertions.assertEquals(2,result.size());
    Assertions.assertEquals(theaterDto,result.get(0));
    Assertions.assertEquals(theaterDto1,result.get(1));




}
@Test
    public void getTheaterByIdTest(){
        int theaterId = 1;

        when(theaterRepo.getById(theaterId)).thenReturn(theater2);
        //when(theaterMapper.toDto(theater2)).thenReturn(theaterDto1);
        List<Theater> theaterList= Arrays.asList(theater1,theater2);
        Theater result = theaterService.getTheaterById(theaterId);

        //verify(theaterRepo,times(1)).findTheaterByTheaterId(1);

        Assertions.assertEquals(theater2,result);
        verify(theaterRepo,times(1)).findTheaterByTheaterId(1);

}

@Test
    public void saveTheaterTest(){

        when(theaterRepo.save(theater1)).thenReturn(theater1);

        Theater result = theaterRepo.save(theater1);

        Assertions.assertEquals(result, theater1);

}

@Test
    public <T> void createSoapMessageTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        TheaterServiceImpl target = new TheaterServiceImpl();
        Class<T>[] paramsTypes = new Class[]{String.class};

        Method createSoapMessageMethod = TheaterServiceImpl.class.getDeclaredMethod("createSoapMessage",paramsTypes);

        createSoapMessageMethod.setAccessible(true);

        String soapMessage = (String)createSoapMessageMethod.invoke(target,theater1);

        String expectedSoap = "";
        Assertions.assertEquals(expectedSoap,soapMessage);
}


    @Test
    public void testPrivateMethod() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        TheaterServiceImpl myClass = new TheaterServiceImpl();
        Method privateMethod = TheaterServiceImpl.class.getDeclaredMethod("privateMethod", int.class);
        privateMethod.setAccessible(true); // Allow access to private method
        int result = (int) privateMethod.invoke(myClass, 6); // Invoke private method
        Assertions.assertEquals(36, result); // Assert the expected result
    }


}
