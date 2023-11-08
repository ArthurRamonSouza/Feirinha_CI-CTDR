"use client"
import fetchProducts from "../api"
import { useState } from 'react'
import React from "react"

const SearchBar = () => {

    const searchIcon = "src/assets/icons/search.png"

    
    const [searchValue, setSearchValue] = useState('')
    
    const handleSearch = (event: any) => {
        event.preventDefault()
        alert('isa')
        setSearchValue('')
        
    }
    return (
        <form className="search-bar" onSubmit={handleSearch}>
           
            <input 
            
                type="text" 
                placeholder="O que vamos comprar hoje?" 
                className="search-bar-input" 
                value={searchValue}
                onChange={ ({ target }) => setSearchValue(target.value) }
                required

            />

            <button type='submit'>
                <img 
                    src={searchIcon} 
                    alt="search" 
                />
            </button>
            
        </form>
    )
}

export default SearchBar