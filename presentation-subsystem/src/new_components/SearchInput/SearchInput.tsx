import React from 'react';
import TextField from '@mui/material/TextField';
import IconButton from '@mui/material/IconButton';
import styles from './SearchInput.module.css';

interface SearchInputProps {
  placeholder?: string;
  onChange?: (value: string) => void;
  value?: string;
}

export const SearchInput: React.FC<SearchInputProps> = ({
  placeholder = 'Поиск...',
  onChange,
  value = '',
}) => {
  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    onChange?.(e.target.value);
  };

  return (
    <div className={styles.searchContainer}>
      <TextField
        variant="outlined"
        placeholder={placeholder}
        value={value}
        onChange={handleChange}
        className={styles.input}
        InputProps={{
          endAdornment: (
            <IconButton>
              <img 
                src="https://dashboard.codeparrot.ai/api/image/Z9k3GyppvFKitUWL/search.png"
                alt="search"
                className={styles.searchIcon}
              />
            </IconButton>
          ),
        }}
      />
    </div>
  );
};
