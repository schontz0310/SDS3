import PageProps from "DTOs/IPageprops";

interface PaginationPops {
  page: PageProps | undefined,
  onPageChange: (page: number) => void
}

const Pagination = ({
  page,
  onPageChange
}:PaginationPops) => {
  return (
    <nav >
      {page && (
      <ul className="pagination d-flex justify-content-end">
        <li className={`page-item ${page.first ? 'disabled' : ''}`}>
          <button className="page-link" onClick={() => onPageChange(page.number - 1)}>Anterior</button>
        </li>
        <li className="page-item disabled">
          <span className="page-link">{`${page?.number + 1} de ${page.totalPages}`}</span>
        </li>
        <li className={`page-item ${page.last ? 'disabled' : ''}`}>
          <button className="page-link" onClick={() => onPageChange(page.number + 1)}>Próxima</button>
        </li>
      </ul>
      )}
    </nav>
  );
}

export default Pagination;