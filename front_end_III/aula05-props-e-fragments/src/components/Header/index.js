import "./style.css";

const Header = (props) => {
    return(
    
        <header>
            <p>Fábrica de Memes</p>
            <nav>
                <ul>
                    <li><a href="#">Home</a></li>
                    <li><a href="#">Sobre</a></li>
                    <li><a href="https://github.com/pedroisb/" target="_blank">Contato</a></li>
                </ul>
            </nav>
        </header>
    
    )
}

export default Header;