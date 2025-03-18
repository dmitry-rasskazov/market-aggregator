import React, { useState } from 'react';
import AppBar from '@mui/material/AppBar';
import TextField from '@mui/material/TextField';
import IconButton from '@mui/material/IconButton';
import styles from './SearchPage.module.css';

interface SearchPageProps {
  onSearch?: (query: string) => void;
}

export const SearchPage: React.FC<SearchPageProps> = ({ onSearch = () => {} }) => {
  const [searchQuery, setSearchQuery] = useState('');

  const handleSearch = () => {
    onSearch(searchQuery);
  };

  const handleKeyPress = (e: React.KeyboardEvent) => {
    if (e.key === 'Enter') {
      handleSearch();
    }
  };

  return (
    <div className={styles.container}>
      <AppBar position="static" className={styles.appBar}>
        <IconButton className={styles.menuIcon}>
          <img src="https://dashboard.codeparrot.ai/api/image/Z9lSMCppvFKitUWp/menu-icon.png" alt="menu" width={24} height={24} />
        </IconButton>
      </AppBar>
      <div className={styles.searchSection}>
        <div className={styles.logo}>
          <h1 className={styles.title}>Поиск</h1>
        </div>
        <div className={styles.searchInputContainer}>
          <TextField
            variant="outlined"
            placeholder="Поиск..."
            value={searchQuery}
            onChange={(e) => setSearchQuery(e.target.value)}
            onKeyPress={handleKeyPress}
            fullWidth
            InputProps={{
              endAdornment: (
                <IconButton onClick={handleSearch}>
                  <img src="https://dashboard.codeparrot.ai/api/image/Z9lSMCppvFKitUWp/search.png" alt="search" width={24} height={24} />
                </IconButton>
              ),
            }}
            className={styles.searchInput}
          />
        </div>
      </div>
    </div>
  );
};

export default SearchPage;

