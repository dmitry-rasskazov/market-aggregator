import React from 'react';
import styles from './Layout.module.css';
import SearchInputComponent from './SearchInputComponent';
import ResultListComponent from './ResultListComponent';

const Layout: React.FC = () => {
  return (
    <div className={styles.container}>
      <header className={styles.header}>
        <div className={styles.logo}>Поиск</div>
        <img src="https://dashboard.codeparrot.ai/api/image/Z9k8ySppvFKitUWW/menu-icon.png" alt="Menu Icon" className={styles.menuIcon} />
      </header>
      <SearchInputComponent className={styles.searchInput} />
      <ResultListComponent className={styles.resultList} />
    </div>
  );
};

export default Layout;

