public class AbstractFactoryPatternEx {
    public static void main(String[] args) {
        System.out.println("***Abstract Factory Pattern Example***");

        IMovieFactory actionMovieFactory = new ActionMovieFactory();
        IHollywoodMovie hAction = actionMovieFactory.getHollywoodMovie();
        IBollywoodMovie bAction = actionMovieFactory.getBollywoodMovie();

        System.out.println("\nAction Movies:");
        System.out.println(hAction.movieName());
        System.out.println(bAction.movieName());

        IMovieFactory comedyMovieFactory = new ComedyMovieFactory();
        IHollywoodMovie hComedy = comedyMovieFactory.getHollywoodMovie();
        IBollywoodMovie bComedy = comedyMovieFactory.getBollywoodMovie();

        System.out.println("\nComedy Movies:");
        System.out.println(hComedy.movieName());
        System.out.println(bComedy.movieName());
    }
}
