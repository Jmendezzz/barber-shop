import { FieldError } from "react-hook-form";

interface Props {
    children: React.ReactNode;
    error?: FieldError;
}

function FormRow({children, error}: Props) {
  return (
    <div className="flex flex-col gap-2">
        {children}
        {error && <p className="text-red-500 text-[15px] font-bold">{error.message}</p>}
    </div>
  )
}

export default FormRow;