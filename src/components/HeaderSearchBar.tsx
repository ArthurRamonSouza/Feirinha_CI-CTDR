import { SearchBar } from "./SearchBar"

export function HeaderSearchBar() {
    const logoPath = "src/assets/logo.png" 
    return (
        <div className= "h-search-bar">
            <img src={ logoPath } alt="logo" />
            <SearchBar />
            <button type="button">Perfil</button>
            <button type="button">Anunciar</button>
        </div>
    )
}