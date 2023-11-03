export function SearchBar() {
    const searchIcon = "src/assets/icons/search.png"

    return (
        <div className="search-bar">
            <button><img src={searchIcon} alt="search" /></button>
            <input type="text" placeholder="O que vamos comprar hoje?" className="search-bar-input" ></input>
        </div>
    )
}