import { Link } from "react-router-dom"
import  SearchBar from "./SearchBar"

export function HeaderSearchBar() {
    const logoPath = "src/assets/logo.png"
    return (
        <div className="h-search-bar">
            <Link to={'/'}>
            <img className="logo" src={logoPath} alt="logo" />
            </Link>
            
            <SearchBar />
            <button type="button">Perfil</button>
            
            <button type="button">Anunciar</button>
            
            
        </div>
    )
}